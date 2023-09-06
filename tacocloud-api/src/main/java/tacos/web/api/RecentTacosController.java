package tacos.web.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.Resources;
import org.springframework.hateoas.Link;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.RequiredArgsConstructor;

import reactor.core.publisher.Mono;
import tacos.Taco;
import tacos.data.TacoRepository;


@RequiredArgsConstructor
@RepositoryRestController
@CrossOrigin(origins = "*")
public class RecentTacosController {
	
	private final TacoRepository tacoRepo;
	private final TacoResourceAssembler assembler;

	@GetMapping(path="/tacos/recent", produces="application/hal+json")
	public Mono<ResponseEntity<CollectionModel<TacoResource>>> recentTacos() {
		return tacoRepo.findAll()
				.take(12)
				.collectList()
				.map(tacos -> {
					Collection<EntityModel<TacoResource>> tacoResources =
							new TacoResourceAssembler().toCollectionModel(tacos).getContent();

					List<TacoResource> tacoResourceList = tacoResources.stream()
							.map(EntityModel::getContent)
							.collect(Collectors.toList());

					CollectionModel<TacoResource> recentResources =
							CollectionModel.of(tacoResourceList);

					recentResources.add(
							linkTo(methodOn(RecentTacosController.class).recentTacos())
									.withRel("recents"));
					return ResponseEntity.ok(recentResources);
				});
	}
}